package br.com.backproject.backproject.controllers.funcionario;

import br.com.backproject.backproject.dto.request.funcionario.FuncionarioRequestDTO;
import br.com.backproject.backproject.dto.response.funcionario.FuncionarioResponseDTO;
import br.com.backproject.backproject.services.funcionario.FuncionarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/v1/funcionarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FuncionarioController {

    @Inject
    private FuncionarioService funcionarioService;

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") final Integer id) {
        final FuncionarioResponseDTO funcionario = funcionarioService.buscarPorId(id);
        return Response.ok(funcionario).build();
    }

    @GET
    public Response obterTodos() {
        final List<FuncionarioResponseDTO> funcionarios = funcionarioService.buscarTodos();
        return Response.ok(funcionarios).build();
    }

    @POST
    public Response cadastrar(final FuncionarioRequestDTO funcionarioRequestDTO) {
        funcionarioService.salvar(funcionarioRequestDTO);
        return Response.status(Response.Status.CREATED).build();
    }

}
