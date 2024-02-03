package symmetrical.physics.subatomic.matter.beta
/*
 * This file is part of Virtual Physics.
 *
 * Copyright (C) [2024] Stephen R. DeSofi AKA Eschelon Azha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import symmetrical.physics.subatomic.balanced.pairs.LeptonPair
import symmetrical.physics.subatomic.matter.leptons.Neutrino
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.subatomic.matter.quarks.Down
import symmetrical.physics.subatomic.matter.quarks.Up
import symmetrical.physics.subatomic.anti_matter.anti_beta.AntiBetaPlus
import symmetrical.physics.subatomic.anti_matter.anti_leptons.Positron
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon


// For more information visit:   https://en.wikipedia.org/wiki/Beta_decay

class BetaPlus(
    private val matterAntiMatter: IMatter = Matter().with(symmetrical.physics.subatomic.matter.beta.BetaPlus::class),
) : LeptonPair(),
    IMatter by matterAntiMatter
{

    fun absorb(neutron: symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon) : Up {
        var down    : Down = neutron.get(1) as Down

        (neutron.get(0)as Quark).gluon.setValue(getPositron().wavelength())
        (neutron.get(2)as Quark).gluon.setValue(getNeutrino().wavelength())

        return Up()
    }

    fun decay(proton: symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon) : Down {
        var up      : Up = proton.get(0) as Up

        var positron: symmetrical.physics.subatomic.anti_matter.anti_leptons.Positron =
            symmetrical.physics.subatomic.anti_matter.anti_leptons.Positron()
        var neutrino: Neutrino = Neutrino()

        positron.setWavelength(up.red())
        neutrino.setWavelength((proton.get(2)as Quark).red())

        setPositron(positron)
        setNeutrino(neutrino)

        return Down()
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    fun getNeutrino() : Neutrino {
        return _lepton as Neutrino
    }
    fun getPositron() : symmetrical.physics.subatomic.anti_matter.anti_leptons.Positron {
        return _antiLepton as symmetrical.physics.subatomic.anti_matter.anti_leptons.Positron
    }
    private fun setNeutrino(neutrino: Neutrino) : symmetrical.physics.subatomic.matter.beta.BetaPlus {
        this._lepton = neutrino
        return this
    }
    private fun setPositron(positron: symmetrical.physics.subatomic.anti_matter.anti_leptons.Positron) : symmetrical.physics.subatomic.matter.beta.BetaPlus {
        this._antiLepton = positron
        return this
    }

}