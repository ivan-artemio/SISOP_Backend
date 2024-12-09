package com.sisop.hexagonal.auth.domain;

import com.sisop.hexagonal.core.shared.domain.StringValueObject;

public class Token extends StringValueObject {
    public Token(final String value) {
        super(value);
    }
}
