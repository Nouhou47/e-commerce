package org.softgraf.customerserver.ecommerce.model;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {}
