package br.com.timetrialfactory.maestro.services;

import java.util.List;

import br.com.timetrialfactory.maestro.models.License;
import br.com.timetrialfactory.maestro.models.LoggedUser;
import br.com.timetrialfactory.maestro.models.ShoppingItem;

public interface LicenseService {

	void saveLicense(LoggedUser user, List<ShoppingItem> games);

	List<License> listUserLicenses(Long userIs);
}