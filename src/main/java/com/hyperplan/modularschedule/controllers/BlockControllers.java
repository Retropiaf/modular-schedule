package com.hyperplan.modularschedule.controllers;

import com.hyperplan.modularschedule.BlockRepository;
import com.hyperplan.modularschedule.models.Block;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;
import java.util.ArrayList;

@RestController
public class BlockControllers {

    private final BlockRepository repository;

    @Autowired
    public BlockControllers(@NonNull final BlockRepository repository){
        this.repository = repository;
    }

    @Nullable
    @RequestMapping(method=RequestMethod.GET, value="/blocks/{id}")
    public Block getBlock(@PathVariable("id") final String id) {
        return repository.findOne(id, null);
    }

    @RequestMapping(method=RequestMethod.GET, value="/blocks")
    public ArrayList<Block> getAllBlocks() {
        return repository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/blocks")
    public Block addBlock(@RequestParam(name = "name") String name) {
        return repository.create(name);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/blocks/{id}")
    public Block deleteBlock() {
        // TODO: implement
        return new Block(null, null);
    }
}
