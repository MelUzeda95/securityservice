package securityservice.command;

public abstract class CommandExecutor {
    protected CommandExecutor() {
    }

    public void execute() {
        this.preExecute();
        this.onExecute();
        this.postExecute();
    }

    protected abstract void onExecute();

    protected abstract void preExecute();

    protected abstract void postExecute();
}
