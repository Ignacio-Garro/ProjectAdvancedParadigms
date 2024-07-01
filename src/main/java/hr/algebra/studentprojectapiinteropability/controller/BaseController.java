package hr.algebra.studentprojectapiinteropability.controller;

import hr.algebra.studentprojectapiinteropability.service.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class BaseController<T> {

    //functional programming: use functional interfaces and lambda expressions for the service methods
    //The methods add, update, and delete now delegate the actual execution of the service methods to the BaseService through a lambda expression

    protected abstract BaseService<T> getService();

    @GetMapping
    public List<T> getAll() {
        return getService().getAll();
    }

    @GetMapping("/{id}")
    public Optional<T> getById(@PathVariable Long id) {
        return getService().getById(id);
    }

    //lamda expressions:for concise and expressive code, typical of functional programming
    //Decoupling: no longer directly call functions from Service
    @PostMapping
    public void add(@RequestBody T entity) {
        getService().execute(service -> service.add(entity));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody T entity) {
        getService().execute(service -> service.update(id, entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        getService().execute(service -> service.delete(id));
    }
}
