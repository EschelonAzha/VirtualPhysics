package symmetrical.cosmic.physics.subatomic.balanced.pairs
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

import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.AntiTau
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.Positron
import symmetrical.cosmic.physics.subatomic.balanced.values.Field
import symmetrical.cosmic.physics.subatomic.matter.leptons.Lepton
import symmetrical.cosmic.physics.subatomic.matter.leptons.Tau
import symmetrical.cosmic.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons.PlusPion
import symmetrical.cosmic.physics.subatomic.matter.leptons.Electron

/*
https://en.wikipedia.org/wiki/Pair_production
 */
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

    companion object {
        fun field(pair:LeptonPair) : Field {
            return pair._lepton.getWavelength().getField()
        }
        fun _field(pair:LeptonPair) : Field {
            return pair._antiLepton.getWavelength().getField()
        }
    }

    fun decay(pion: PlusPion) : TauAntiTauPair {
        return this
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    fun getElectron() : Electron {
        return _lepton as Electron
    }
    fun getField() : Field {
        return TauAntiTauPair.field(this)
    }
    fun getAntiField() : Field {
        return TauAntiTauPair._field(this)
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
    fun setAccepted(accepted:Boolean) : TauAntiTauPair {
        getSpin().setSpin(accepted)
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

}