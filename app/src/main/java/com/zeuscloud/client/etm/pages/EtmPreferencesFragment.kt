/*
 * Nextcloud Android client application
 *
 * @author Chris Narkiewicz
 * Copyright (C) 2019 Chris Narkiewicz <hello@ezaquarii.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.zeuscloud.client.etm.pages

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.zeuscloud.client.etm.EtmBaseFragment
import com.owncloud.android.R
import com.owncloud.android.databinding.FragmentEtmPreferencesBinding

class EtmPreferencesFragment : EtmBaseFragment() {
    private var _binding: FragmentEtmPreferencesBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentEtmPreferencesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val builder = StringBuilder()
        vm.preferences.forEach { builder.append("${it.key}: ${it.value}\n") }
        binding.etmPreferencesText.text = builder
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_etm_preferences, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.etm_preferences_share -> {
                onClickedShare()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onClickedShare() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Nextcloud preferences")
        intent.putExtra(Intent.EXTRA_TEXT, binding.etmPreferencesText.text)
        intent.type = "text/plain"
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
