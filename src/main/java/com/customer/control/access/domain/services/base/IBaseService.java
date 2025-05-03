package com.customer.control.access.domain.services.base;

import java.util.List;

/**
 * Serviço genérico com tipos de Input (IN) e Output (OUT).
 *
 * @param <IN>  tipo de dado que entra no serviço (ex.: DTO de request)
 * @param <OUT> tipo de dado que sai do serviço (ex.: DTO de response)
 */
public interface IBaseService<IN, OUT> {

    OUT save(IN input);

    OUT update(IN input);

    OUT findById(Long id);
    List<OUT> findAll();

    OUT deleteById(Long id);
}
