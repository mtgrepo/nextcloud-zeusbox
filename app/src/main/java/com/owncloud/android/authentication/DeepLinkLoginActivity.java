package com.owncloud.android.authentication;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.zeuscloud.client.di.Injectable;
import com.owncloud.android.R;

public class DeepLinkLoginActivity extends AuthenticatorActivity implements Injectable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!getResources().getBoolean(R.bool.multiaccount_support) &&
            accountManager.getAccounts().length == 1) {
            Toast.makeText(this, R.string.no_mutliple_accounts_allowed, Toast.LENGTH_LONG).show();
            return;
        }

        setContentView(R.layout.deep_link_login);

        Uri data = getIntent().getData();

        if (data != null) {
            try {
                String prefix = getString(R.string.login_data_own_scheme) + PROTOCOL_SUFFIX + "login/";
                LoginUrlInfo loginUrlInfo = parseLoginDataUrl(prefix, data.toString());

                TextView loginText = findViewById(R.id.loginInfo);
                loginText.setText(String.format(getString(R.string.direct_login_text), loginUrlInfo.username,
                                                loginUrlInfo.serverAddress));
            } catch (IllegalArgumentException e) {
                Toast.makeText(this, R.string.direct_login_failed, Toast.LENGTH_LONG).show();
            }
        }
    }
}
