/*
 * (c) Copyright 2016 Hewlett-Packard Development Company, L.P.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0 which accompany this distribution.
 *
 * The Apache License is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package io.cloudslang.lang.cli.utils;

import io.cloudslang.lang.api.Slang;
import io.cloudslang.lang.compiler.SlangSource;
import io.cloudslang.lang.compiler.modeller.model.Metadata;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * User: bancl
 * Date: 1/11/2016
 */
@Component
public class MetadataHelperImpl implements MetadataHelper {

    @Autowired
    private Slang slang;

    @Override
    public Metadata extractMetadata(File file) {
        Validate.notNull(file.getAbsolutePath(), "File path can not be null");
        Validate.isTrue(file.isFile(), "File: " + file.getName() + " was not found");

        return slang.extractMetadata(SlangSource.fromFile(file));
    }
}
