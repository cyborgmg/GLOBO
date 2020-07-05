package io.swagger.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.dao.ContatoDao;
import io.swagger.model.Contato;
import io.swagger.model.ContatoUpdate;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-04T13:15:51.513Z[GMT]")
@Controller
@CrossOrigin(origins="*")
public class IdContatoApiController implements IdContatoApi {

    private static final Logger log = LoggerFactory.getLogger(IdContatoApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private ContatoDao contatoDao;
    
    @org.springframework.beans.factory.annotation.Autowired
    public IdContatoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        contatoDao = new ContatoDao(); 
    }
    
    public ResponseEntity<String> idContatoDelete(@ApiParam(value = "Identificador único de objetos do tipo Contato",required=true) 
    @PathVariable("idContato") Integer idContato) {
    	
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	boolean excluido = contatoDao.exclui(idContato.toString());
    			
    			if(excluido) {
    				return new ResponseEntity<String>("Contato excluido.",HttpStatus.ACCEPTED);
    			}else {
    				throw new RuntimeException("Erro ao tentar excluir cliente.");
    			}
            	
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
   }

    public ResponseEntity<Contato> idContatoGet(@ApiParam(value = "Identificador único de objetos do tipo Contato",required=true) 
    @PathVariable("idContato") Integer idContato) {
    	
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	Contato contato = contatoDao.consultaPorId(idContato.toString());
    			
    			if(contato==null) {
    				return new ResponseEntity<Contato>(HttpStatus.NOT_FOUND); 
    			}else {
    				return new ResponseEntity<Contato>(contato,HttpStatus.OK);
    			}
            	
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Contato>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Contato>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> idContatoPut(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ContatoUpdate body
    	,@ApiParam(value = "Identificador único de objetos do tipo Contato",required=true) @PathVariable("idContato") Integer idContato) {
    	
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	boolean contatoUpdate = contatoDao.alteraPorId(idContato.toString(), body);
        		
        		if(contatoUpdate) {
        			
        			return new ResponseEntity<String>("Contato alterado.", HttpStatus.ACCEPTED);
        			
        		}else {	
        			throw new RuntimeException("Erro ao tentar alterar Cliente.");
        		}
        		
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

}
