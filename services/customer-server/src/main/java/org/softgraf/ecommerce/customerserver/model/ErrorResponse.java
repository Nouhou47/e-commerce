package org.softgraf.ecommerce.customerserver.model;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {}
