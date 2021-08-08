package com.eviltester.java.lambdafunctions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class LambdaFunctionsVsClassesTest {

    @Test
    public void canPassInClassImplementingInterfaceToExecute(){

        Assert.assertTrue(
            new ExecuteSomething().
                codeToExecute(new ExecutionCodeInAClass()).
                execute()
        );
    }

    @Test
    public void canPassInLambdaToExecute(){

        Assert.assertTrue(
            new ExecuteSomething().
                    codeToExecute(() -> {
                        System.out.println("Running Code from Lambda");
                        return true;
                    }).
                    execute()
        );
    }

    @Test
    public void canUseLambdaAssignedToVariableToExecute(){

        SomethingToExecute myCode = () -> {
            System.out.println("Running code from Lambda assigned to variable");
            return true;
        };

        Assert.assertTrue(
                new ExecuteSomething().
                        codeToExecute(myCode).
                        execute()
        );

        // because it is in a variable we can re-use it

        Assert.assertTrue(
            new ExecuteSomething().codeToExecute(myCode).execute()
        );
    }

    @Test
    public void lambdaVariablesAreFinalOrEffectivelyFinal(){

        // Lambda can use variables that are in scope so long as they
        // are final or effectively final

        int execution=1;

        SomethingToExecute myCode = () -> {
            System.out.println("Running Code from Lambda execution " + execution);
            return true;
        };

        // variables used in a Lambda should be final or 'effectively' final
        // i.e they should either be defined be unchangeable, or not change
        // uncomment the line below will cause a syntax error because then
        // execution would not be effectively final

        // execution++;

        Assert.assertTrue(
            new ExecuteSomething().codeToExecute(myCode).execute()
        );
    }


    // To replicate the variables in lambda with objects we can
    // use the constructors
    private class CodeWithVariable implements SomethingToExecute{

        private final int execution;

        CodeWithVariable(int execution){
            this.execution = execution;
        }

        @Override
        public boolean executeCode() {
            System.out.println("Running CodeWithVariable object execution " + execution);
            return true;
        }
    }

    @Test
    public void useConstructorsToIntroduceScopeVariablesForObjects(){

        int execution=1;

        Assert.assertTrue(
                new ExecuteSomething().codeToExecute(
                        new CodeWithVariable(execution)).execute()
        );

        // because the variable is passed to an object in constructor
        // not embedded in a lambda it does not need to be final

        execution++;

        Assert.assertTrue(
                new ExecuteSomething().codeToExecute(
                        new CodeWithVariable(execution)).execute()
        );

    }

    @Test
    public void lambdaCanTriggerSideEffects(){

        ArrayList<Integer> executionCount = new ArrayList<>();
        executionCount.add(1);

        // The executionCount list is effectively final...
        // it always points to the same list.
        //
        // But it is still possible to introduce side-effects because
        // we can change the values in the list.
        //
        // Objects can be used to have side-effects from within a Lambda

        SomethingToExecute myCode = () -> {
            int count = executionCount.get(0);
            System.out.println("Running Code from Lambda execution with side effects " +
                    count);
            count++;
            executionCount.add(0, count);
            return true;
        };

        Assert.assertTrue(
                new ExecuteSomething().codeToExecute(myCode).execute()
        );

        Assert.assertEquals(2, executionCount.get(0).intValue());

        Assert.assertTrue(
                new ExecuteSomething().codeToExecute(myCode).execute()
        );

        Assert.assertEquals(3, executionCount.get(0).intValue());
    }
}


class ExecuteSomething{

    private SomethingToExecute executionCode;

    public ExecuteSomething codeToExecute(SomethingToExecute executionCode){
        this.executionCode = executionCode;
        return this;
    }
    public boolean execute(){

        return executionCode.executeCode();
    }

}

interface SomethingToExecute {

    boolean executeCode();
}

class ExecutionCodeInAClass implements SomethingToExecute{

    @Override
    public boolean executeCode() {
        System.out.println("Executed Code in object of class ExecutionCodeInAClass");
        return true;
    }
}