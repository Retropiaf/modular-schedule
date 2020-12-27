package com.hyperplan.modularschedule;

import com.google.common.base.Strings;
import com.hyperplan.modularschedule.models.Block;
import com.mongodb.*;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BlockRepository implements BlockRepositoryInterface {

    // TODO: create POJO/DBObject converters
    // TODO: create database request and response objects?

    private DBCollection collection;
    BlockRepository() {
        try {
            // Move this to a configuration class and turn into a bean
            MongoClient mongoClient = new MongoClient();
            DB database = mongoClient.getDB("blocks");
            this.collection = database.getCollection("blocks");

        } catch (UnknownHostException e) {
            // TODO: do something with e
        }
    }

    @Nullable
    public Block findOne(@Nullable final String id, @Nullable final String name) {
        final DBObject query = new BasicDBObject();
        if (!Strings.isNullOrEmpty(id)) {
            query.put("_id", id);
        }
        if (!Strings.isNullOrEmpty(id)) {
            query.put("name", name);
        }

        final DBObject target = this.collection.findOne(query);

        if (target != null) {
            final String targetId = (String) target.get("_id");
            final String targetName = (String) target.get("name");
            return new Block(targetId, targetName);
        }

        return null;
    }

    // TODO: Should this return the Block, its id, both?
    public Block create(@NonNull final String name) {
        final DBObject newBlock = new BasicDBObject();
        newBlock.put("name", name);

        final String id = new ObjectId().toString();
        newBlock.put("_id", id);

        collection.insert(newBlock);

        return new Block(id, name);
    }

    public ArrayList<Block> findAll() {
        final List<DBObject> blockList = this.collection.find().toArray();
        final ArrayList<Block> blocks = new ArrayList<>(){};

        blockList.forEach(dbObject -> {
            final Block block = new Block((String) dbObject.get("_id"), (String) dbObject.get("name"));
            blocks.add(block);
        });

        return blocks;

    }
}
