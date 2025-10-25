package br.com.bytecooks.pagamentos.controller.v1;

import br.com.bytecooks.pagamentos.controller.dto.request.PagamentoRequest;
import br.com.bytecooks.pagamentos.controller.dto.response.PagamentoResponse;
import br.com.bytecooks.pagamentos.service.PagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/pagamentos")
@RequiredArgsConstructor
@Tag(name = "Pagamentos", description = "Gerenciamento de pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @Operation(
            summary = "Cadastrar novo Pagamento",
            description = "Registra um novo Pagamento com o ID do Pedido e da Forma de Pagamento já vinculada"
    )
    @PostMapping
    public ResponseEntity<PagamentoResponse> criar(@Valid @RequestBody PagamentoRequest request) {
        var response = pagamentoService.criar(request);
        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @Operation(
            summary = "Retornar todos os Pagamentos",
            description = "Busca na base todos os Pagamentos e retorna paginado"
    )
    @GetMapping
    public ResponseEntity<Page<PagamentoResponse>> obterTodos(Pageable pageable) {
        var response = pagamentoService.obterTodos(pageable);

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Buscar Pagamento por ID",
            description = "Retorna os dados de um Pagamento com base no ID informado. Contém todos os dados de um Pagamento"
    )
    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponse> obterPorId(@PathVariable Long id) {
        var response = pagamentoService.obterPorId(id);

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Deletar Pagamento",
            description = "Faz a deleção física de um Pagamento correspondente ao ID informado"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pagamentoService.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Atualizar todos os parâmetros de um Pagamento",
            description = "Faz a atualização de todos os parâmetros de um Pagamento que seja correspondente ao ID informado"
    )
    @PutMapping("/{id}")
    public ResponseEntity<PagamentoResponse> atualizar(@PathVariable Long id, @Valid @RequestBody PagamentoRequest request) {
        var response = pagamentoService.atualizar(id, request);

        return ResponseEntity.ok(response);
    }
}
