package br.com.timetrialfactory.maestro.services;

import static java.util.UUID.randomUUID;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.timetrialfactory.maestro.assembler.GameAssembler;
import br.com.timetrialfactory.maestro.assembler.LicenseAssembler;
import br.com.timetrialfactory.maestro.assembler.UserAssembler;
import br.com.timetrialfactory.maestro.daos.LicenseDAO;
import br.com.timetrialfactory.maestro.dto.LicenseDTO;
import br.com.timetrialfactory.maestro.models.License;
import br.com.timetrialfactory.maestro.models.LoggedUser;
import br.com.timetrialfactory.maestro.models.ShoppingItem;

@Service("licenseService")
@Transactional
public class LicenseServiceImpl implements LicenseService {

	private final static BigDecimal free = new BigDecimal("0");

	@Autowired
	private LicenseDAO dao;

	@Autowired
	private LicenseAssembler licenseAssembler;

	@Autowired
	private UserAssembler userAssembler;
	
	@Autowired
	private GameAssembler gameAssembler;

	@Override
	public void saveLicense(LoggedUser user, List<ShoppingItem> games) {
		if (user != null && games != null) {
			for (ShoppingItem gameInCart : games) {
				License license = new License();
				license.setCode(new LicenseGenerator().generateLicense());
				license.setUser(userAssembler.toEntity(user.getLoggedUser()));
				license.setGame(gameAssembler.toEntity(gameInCart.getGame()));
				if (gameInCart.getGame().getPrice().equals(free)) {
					license.setCheckedCode(true);
				} else {
					license.setCheckedCode(false);
				}
				dao.saveLicense(license);
			}
		}
	}

	@Override
	public Set<LicenseDTO> listUserLicenses(Long userId) {
		return licenseAssembler.toObjectList(dao.listLicenses(userId));
	}

	private final class LicenseGenerator {

		private LicenseGenerator() {
		}

		private String generateLicense() {
			return randomUUID().toString();
		}
	}

}
