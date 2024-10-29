package org.softgraf.ecommerce.productserver.model;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {}
