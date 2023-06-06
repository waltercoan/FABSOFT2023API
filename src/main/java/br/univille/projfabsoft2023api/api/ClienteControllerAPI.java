package br.univille.projfabsoft2023api.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft2023api.entity.Cliente;
import br.univille.projfabsoft2023api.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteControllerAPI {
    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){
        var listaClientes = service.getAll();
        return new ResponseEntity<List<Cliente>>
            (listaClientes,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Cliente> 
                incluirCliente(@RequestBody Cliente cliente){
        cliente.setId(0);
        service.save(cliente);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> 
                alterarCliente(@PathVariable("id") Cliente clienteAntigo, 
                            @RequestBody Cliente clienteNovo){

        clienteAntigo.setNome(clienteNovo.getNome());
        clienteAntigo.setEndereco(clienteNovo.getEndereco());
        clienteAntigo.setDataNascimento(clienteNovo.getDataNascimento());
        clienteAntigo.setEmail(clienteNovo.getEmail());
        clienteAntigo.setTelefone(clienteNovo.getTelefone());

        service.save(clienteAntigo);
        return new ResponseEntity<Cliente>(clienteAntigo,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> 
                deleteCliente(@PathVariable("id") Cliente clienteAntigo){
        service.delete(clienteAntigo.getId());
        return new ResponseEntity<Cliente>(clienteAntigo,HttpStatus.OK);
    }
}
