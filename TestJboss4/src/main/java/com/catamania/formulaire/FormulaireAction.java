package com.catamania.formulaire;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class FormulaireAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		String resultat = null;
		String champ1 = ((FormulaireForm) form).getChamp1();
		String champ2 = ((FormulaireForm) form).getChamp2();

		long l = 3000;
		System.out.println("FormulaireAction submitted : " + champ1 + " " + champ2
				+ "\n waiting for " + l);
		Thread.sleep(l);
		
		resultat = "succes";

		return mapping.findForward(resultat);
	}
}
