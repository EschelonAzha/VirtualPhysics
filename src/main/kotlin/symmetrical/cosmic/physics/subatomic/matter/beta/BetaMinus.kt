package symmetrical.cosmic.physics.subatomic.matter.beta
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

import symmetrical.cosmic.physics.subatomic.balanced.pairs.LeptonPair
import symmetrical.cosmic.physics.subatomic.matter.quarks.Down
import symmetrical.cosmic.physics.subatomic.matter.quarks.Up
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_beta.AntiBetaMinus
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.AntiNeutrino
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic.physics.subatomic.matter.leptons.Electron

/*
https://en.wikipedia.org/wiki/Beta_decay
 */
class BetaMinus(
    private val matterAntiMatter: IMatter = Matter(BetaMinus::class),
) : LeptonPair(),
    IMatter by matterAntiMatter
{
    constructor() : this(
        Matter(BetaMinus::class),
    )
    fun decay(baryon: Baryon) : Up {
        var down      : Down = baryon.get(1) as Down

        var electron: Electron = Electron()
        var antiNeutrino: AntiNeutrino = AntiNeutrino()

        electron.setWavelength(down.red())
        antiNeutrino.setWavelength(baryon)

        setElectron(electron)
        setAntiNeutrino(antiNeutrino)

        return Up()
    }
    fun getAntiNeutrino() : AntiNeutrino {
        return _antiLepton as AntiNeutrino
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    fun getElectron() : Electron {
        return _lepton as Electron
    }
    private fun setAntiNeutrino(antiNeutrino: AntiNeutrino) : BetaMinus {
        this._antiLepton = antiNeutrino
        return this
    }
    private fun setElectron(electron: Electron) : BetaMinus {
        this._lepton = electron
        return this
    }
}