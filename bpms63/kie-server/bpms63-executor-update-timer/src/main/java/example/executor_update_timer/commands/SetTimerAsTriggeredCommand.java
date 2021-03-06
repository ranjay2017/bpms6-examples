package example.executor_update_timer.commands;

import org.kie.api.executor.Command;
import org.kie.api.executor.CommandContext;
import org.kie.api.executor.ExecutionResults;

/**
 * 
 * If a process instance is stopped on a timer we can set it as triggered and
 * make the process skip it.
 * 
 * @author wsiqueir
 *
 */
public class SetTimerAsTriggeredCommand extends AbstractTimerActionCommand
		implements Command {

	public ExecutionResults execute(CommandContext ctx) throws Exception {
		return super.execute(ctx, updateTimerService::setAsTriggered);
	}

}