package jp.co.sample.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministertorController {

	@Autowired
	private AdministratorService administratorService;

	/**
	 * InsertAdministratorFormをインスタンス化し、そのままreturnする処理
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}

	/**
	 * administrator/insert.htmlにフォワード
	 * 
	 * @return
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	
	/**
	 * 管理者情報を登録する
	 * ・Administratorド名をインスタンス化
	 * ・リクエストパラメータが入っているInsertAdministratorFormオブジェクトの中身をインスタンス化したAdministratorドメインオブジェクトにコピー
	 * ・administratorServiceのinsert()メソッドを呼ぶ
	 * ・「/」（ログイン画面）にリダイレクト
	 */
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administrator administrator = new Administrator();
		BeanUtils.copyProperties(form, administrator);
		administratorService.insert(administrator);
		return "redirect:/";
	}
}
