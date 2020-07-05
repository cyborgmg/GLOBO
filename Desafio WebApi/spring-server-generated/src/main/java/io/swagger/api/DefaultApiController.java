package io.swagger.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.dao.ContatoDao;
import io.swagger.model.Contato;
import io.swagger.model.ContatoCreate;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-04T15:41:57.543Z[GMT]")
@Controller
@CrossOrigin(origins="*")
public class DefaultApiController implements DefaultApi {

    private static final Logger log = LoggerFactory.getLogger(DefaultApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    private ContatoDao contatoDao;

    @org.springframework.beans.factory.annotation.Autowired
    public DefaultApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        contatoDao = new ContatoDao(); 
    }

    public ResponseEntity<List<Contato>> rootGet(@ApiParam(value = "Quantidade de registros a ser retornada em uma única página") @Valid @RequestParam(value = "size", required = false) Integer size
,@ApiParam(value = "Página onde se encontra o subconjunto de registros desejado") @Valid @RequestParam(value = "page", required = false) Integer page
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	List<Contato> contatos = contatoDao.sublist(page, size);
            	
                return new ResponseEntity<List<Contato>>(contatos,HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Contato>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Contato>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> rootPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ContatoCreate body) {
    	
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	Contato newContato = contatoDao.salva(body);
            	
            	if(newContato==null) {
					throw new RuntimeException("Erro ao tentar cadastrar novo cliente.");
				}
            	
                return new ResponseEntity<String>("Contato criado", HttpStatus.CREATED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

}
