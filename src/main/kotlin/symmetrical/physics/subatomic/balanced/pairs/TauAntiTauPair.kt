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
import symmetrical.physics.subatomic.anti_matter.anti_leptons.AntiTau
import symmetrical.physics.subatomic.anti_matter.anti_leptons.Positron
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.matter.leptons.Lepton
import symmetrical.physics.subatomic.matter.leptons.Tau
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.physics.subatomic.matter.hadrons.mesons.PlusPion
import symmetrical.physics.subatomic.matter.leptons.Electron


// For more information visit:   https://en.wikipedia.org/wiki/Pair_production

class TauAntiTauPair(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter().with(TauAntiTauPair::class),
) : LeptonPair(),
    IMatterAntiMatter by matterAntiMatter
{
    init {
        setAccepted(true)
        setReason("")
        setReasonCode(0)
    }
    override fun with(lepton: Lepton, antiLepton: AntiLepton) : TauAntiTauPair {
        super.with(lepton, antiLepton)
        return this
    }
    fun with(accepted:Boolean, reasonCode:Int, reason:String, newValue: Field, oldValue: Field) : TauAntiTauPair {
        super.with(Tau().with(newValue), AntiTau().with(oldValue))
        setAccepted(accepted)
        setReasonCode(reasonCode)
        setReason(reason)
        return this
    }
    fun decay(pion: PlusPion) : TauAntiTauPair {
        return this
    }

    fun getElectron() : Electron {
        return _lepton as Electron
    }
    fun getField() : Field {
        return _lepton.getWavelength().getField()
    }
    fun getAntiField() : Field {
       return _antiLepton.getWavelength().getField()
    }
    fun getPositron() : Positron {
        return _antiLepton as Positron
    }

    fun getReason() : String {
        return getWavelength().getField().toString()
    }

    fun getReasonCode() : Int {
        return getTemperature().getField().toInt()
    }

    fun isAccepted() : Boolean {
        return getSpin().isPlus()
    }
    private fun setAccepted(accepted:Boolean) : TauAntiTauPair {
        getSpin().setContent(accepted)
        return this
    }

    fun setReason(content:String) : TauAntiTauPair {
        getWavelength().setContent(content)
        return this
    }
    fun setReasonCode(value:Int) : TauAntiTauPair {
        getTemperature().setContent(value)
        return this
    }
    private fun setElectron(electron: Electron) : TauAntiTauPair {
        this._lepton = electron
        return this
    }
    private fun setPositron(positron: Positron) : TauAntiTauPair {
        this._antiLepton = positron
        return this
    }




    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

}