package com.catamania.formulaire;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class FormulaireForm extends ActionForm {
	 String champ1;

	  String champ2;

	  public String getChamp2() {
	    return champ2;
	  }

	  public void setChamp2(String champ2) {
	    this.champ2 = champ2;
	  }

	  public String getChamp1() {
	    return champ1;
	  }

	  public void setChamp1(String champ1) {
	    this.champ1 = champ1;
	  }

	  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
	    ActionErrors errors = new ActionErrors();
	    return errors;
	  }

	  public void reset(ActionMapping mapping, HttpServletRequest request) {
	    this.champ2 = null;
	    this.champ1 = null;
	  }
}
