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
import symmetrical.physics.subatomic.matter.quarks.Down
import symmetrical.physics.subatomic.matter.quarks.Up
import symmetrical.physics.subatomic.anti_matter.anti_beta.AntiBetaMinus
import symmetrical.physics.subatomic.anti_matter.anti_leptons.AntiNeutrino
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon
import symmetrical.physics.subatomic.matter.leptons.Electron


// For more information visit:   https://en.wikipedia.org/wiki/Beta_decay

class BetaMinus(
    private val matterAntiMatter: IMatter = Matter().with(symmetrical.physics.subatomic.matter.beta.BetaMinus::class),
) : LeptonPair(),
    IMatter by matterAntiMatter
{

    fun decay(baryon: symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon) : Up {
        var down      : Down = baryon.get(1) as Down

        var electron: symmetrical.physics.subatomic.matter.leptons.Electron =
            symmetrical.physics.subatomic.matter.leptons.Electron()
        var antiNeutrino: symmetrical.physics.subatomic.anti_matter.anti_leptons.AntiNeutrino =
            symmetrical.physics.subatomic.anti_matter.anti_leptons.AntiNeutrino()

        electron.setWavelength(down.red())
        antiNeutrino.setWavelength(baryon)

        setElectron(electron)
        setAntiNeutrino(antiNeutrino)

        return Up()
    }
    fun getAntiNeutrino() : symmetrical.physics.subatomic.anti_matter.anti_leptons.AntiNeutrino {
        return _antiLepton as symmetrical.physics.subatomic.anti_matter.anti_leptons.AntiNeutrino
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    fun getElectron() : symmetrical.physics.subatomic.matter.leptons.Electron {
        return _lepton as symmetrical.physics.subatomic.matter.leptons.Electron
    }
    private fun setAntiNeutrino(antiNeutrino: symmetrical.physics.subatomic.anti_matter.anti_leptons.AntiNeutrino) : symmetrical.physics.subatomic.matter.beta.BetaMinus {
        this._antiLepton = antiNeutrino
        return this
    }
    private fun setElectron(electron: symmetrical.physics.subatomic.matter.leptons.Electron) : symmetrical.physics.subatomic.matter.beta.BetaMinus {
        this._lepton = electron
        return this
    }
}