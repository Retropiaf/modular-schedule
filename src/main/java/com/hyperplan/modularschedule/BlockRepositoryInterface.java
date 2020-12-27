package com.hyperplan.modularschedule;

import com.hyperplan.modularschedule.models.Block;
import com.mongodb.lang.Nullable;

public interface BlockRepositoryInterface {

    @Nullable
    Block findOne(@Nullable final String id, @Nullable final String name);
    Block create(final String name);
    Iterable<Block> findAll();

}
