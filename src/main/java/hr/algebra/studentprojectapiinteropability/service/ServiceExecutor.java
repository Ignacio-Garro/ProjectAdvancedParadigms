package hr.algebra.studentprojectapiinteropability.service;

@FunctionalInterface
public interface ServiceExecutor<T> {
    // functional interface used to execute methods on the service
    //allow methods to be passed as parameters
    void execute(T service);
}
