package symmetrical.physics.subatomic.balanced.pairs
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

import symmetrical.physics.subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.physics.subatomic.anti_matter.anti_leptons.Positron
import symmetrical.physics.subatomic.matter.leptons.Lepton
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.physics.subatomic.matter.hadrons.mesons.PlusPion
import symmetrical.physics.subatomic.matter.leptons.Electron


// For more information visit:   https://en.wikipedia.org/wiki/Pair_production

class ElectronPositron(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter().with(ElectronPositron::class),
) : LeptonPair(),
    IMatterAntiMatter by matterAntiMatter
{

    override fun with(lepton: Lepton, antiLepton: symmetrical.physics.subatomic.anti_matter.anti_leptons.AntiLepton) : ElectronPositron {
        super.with(lepton, antiLepton)
        return this
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
//    fun decay(pion: PlusPion) : ElectronPositron<PlusPion> {
//        return this
//    }
    fun decay(pion: symmetrical.physics.subatomic.matter.hadrons.mesons.PlusPion) : ElectronPositron {
        return this
    }

    fun getElectron() : symmetrical.physics.subatomic.matter.leptons.Electron {
        return _lepton as symmetrical.physics.subatomic.matter.leptons.Electron
    }
    fun getPositron() : symmetrical.physics.subatomic.anti_matter.anti_leptons.Positron {
        return _antiLepton as symmetrical.physics.subatomic.anti_matter.anti_leptons.Positron
    }
//    private fun setElectron(electron: Electron) : ElectronPositron<PlusPion> {
//        this.leptons[0] = electron
//        return this
//    }
//    private fun setPositron(positron: Positron) : ElectronPositron<PlusPion> {
//        this.leptons[1] = positron
//        return this
//    }
    private fun setElectron(electron: symmetrical.physics.subatomic.matter.leptons.Electron) : ElectronPositron {
        this._lepton = electron
        return this
    }
    private fun setPositron(positron: symmetrical.physics.subatomic.anti_matter.anti_leptons.Positron) : ElectronPositron {
        this._antiLepton = positron
        return this
    }

}