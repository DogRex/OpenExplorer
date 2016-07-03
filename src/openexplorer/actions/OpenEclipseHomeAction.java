package openexplorer.actions;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import openexplorer.util.Messages;
import openexplorer.util.OperatingSystem;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class OpenEclipseHomeAction implements IWorkbenchWindowActionDelegate {

	private static final String ECLIPSE_HOME = System.getProperty("eclipse.home.location");

	private Shell shell;

	@Override
	public void init(IWorkbenchWindow window) {
		shell = window.getShell();
	}

	@Override
	public void run(IAction action) {
		URI eclipseHomeUri = URI.create(ECLIPSE_HOME);
		File homeFile = new File(eclipseHomeUri);
		try {
			OperatingSystem.INSTANCE.openInBrowser(homeFile);
		} catch (IOException e) {
			MessageDialog.openError(shell, Messages.OpenExploer_Error, "Failed to open Eclipse home: " + ECLIPSE_HOME);
			e.printStackTrace();
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}

	@Override
	public void dispose() {

	}
}
