# Books API

## TODO: 

+ [] Restante dos métodos CRUD
+ [] Cardinalidade banco 
+ [x] Converti as classes para portugues
+ Tipos dos campos: 
    + Talvez uma classe para o ``author``
    + Enum pro 
        + [x] ``tipo`` 
        + [x] ``formato``
        + [x] ``acabamento``
        + [x] ``idioma``
        + [x] ``pais``
    + [] Criar uma classe ``generos`` com uma tabela auxiliar
+ [] Talvez um DTO, achar uma melhor forma de transmitir a informação
+ [] Fazer os ids do banco contar a partir do 1000
+ [] Tratar melhor as exceções


### Exemplo de tratamento global de exceções

Eu estou tirando essa classe do projeto porque não faz mais sentido pra mim, porém, eu não queria jogar fora esse exemplo. Eu usei ele para tratar a exceção que ocorre quando mandamos um valor null para um atributo que está anotado como @Column(nullable = false), como é o caso da classe autor. 

Desisti dessa abordagem porque ela fica muito genérica. Acredito que existe uma forma de tratar a exceção de uma forma mais específica. 

```java
@Entity
@Table(name = "autores")
public class Autor {

	@Id	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String nacionalidade;

	@Column(nullable = false) @JsonFormat(pattern="yyyy-MM-dd")
	private Date dataNascimento;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataMorte;

```

```java

package com.books.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<BookError> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        BookError error = new BookError();
        error.setErrorMessage("Erro de integridade de dados. Todos os campos são obrigatórios, exceto 'collection'.");
        error.setFieldsAvailable("collection, title, author, publisher, type, format, pages, edition, editionYear, genres, finishing, language, country e bookQuantity.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}

```

```java

package com.books.exceptions;

public class BookError {

    private String errorMessage;
    private String fieldsAvailable;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getFieldsAvailable() {
        return fieldsAvailable;
    }

    public void setFieldsAvailable(String fieldsAvailable) {
        this.fieldsAvailable = fieldsAvailable;
    }

}

```