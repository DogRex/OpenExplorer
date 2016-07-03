package openexplorer.actions;

import java.io.IOException;

import openexplorer.util.Messages;
import openexplorer.util.OperatingSystem;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class OpenWorkspaceAction implements IWorkbenchWindowActionDelegate {

	private Shell shell;

	@Override
	public void run(IAction action) {
		IResource workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		try {
			OperatingSystem.INSTANCE.openInBrowser(workspaceRoot);
		} catch (IOException e) {
			MessageDialog.openError(shell, Messages.OpenExploer_Error, "Failed to open Workspace directory: "
					+ workspaceRoot.getLocationURI());
			e.printStackTrace();
		}
	}

	@Override
	public void init(IWorkbenchWindow window) {
		this.shell = window.getShell();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}

	@Override
	public void dispose() {
	}

}
