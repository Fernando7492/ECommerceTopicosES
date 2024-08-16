package com.topicos.storage.create.exception;

import java.io.Serial;

public class DuplicateRecordException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public DuplicateRecordException(String message) {
        super(message);
    }
}
