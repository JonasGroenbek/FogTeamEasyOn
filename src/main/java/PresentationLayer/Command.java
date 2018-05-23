package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "link", new Link() );
        commands.put( "createorder", new CreateOrder() );
        commands.put( "updateorder", new UpdateOrder() );
        commands.put( "updateBuilder", new UpdateBuilder() );
        commands.put( "makebill", new MakeBill() );
        commands.put( "showorders", new ShowOrders() );
        /*commands.put( "searchuserorders", new SearchUserOrders() );
        commands.put( "searchorderid", new SearchOrderID() );*/

    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException;
}
