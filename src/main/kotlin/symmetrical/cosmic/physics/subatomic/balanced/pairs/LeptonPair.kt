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
import symmetrical.cosmic.physics.subatomic.balanced.Particle
import symmetrical.cosmic.physics.subatomic.balanced.values.Field
import symmetrical.cosmic.physics.subatomic.matter.leptons.Lepton
import symmetrical.cosmic.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.cosmic.physics.subatomic.spacial.IParticleBeam
/*
https://en.wikipedia.org/wiki/Pair_production
 */
open class LeptonPair(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(LeptonPair::class),
) : Particle(),
    IMatterAntiMatter by matterAntiMatter
{
    constructor() : this(
        MatterAntiMatter(LeptonPair::class),
    )

    companion object {
        fun field(pair:LeptonPair) : Field {
            return pair._lepton.getWavelength().getField()
        }
        fun _field(pair:LeptonPair) : Field {
            return pair._antiLepton.getWavelength().getField()
        }
    }

    public lateinit var _lepton     : Lepton
    public lateinit var _antiLepton : AntiLepton


//    constructor(lepton:Lepton, antiLepton:AntiLepton) {
//        i(lepton, antiLepton)
//    }

    fun i(lepton:Lepton, antiLepton: AntiLepton) : LeptonPair {
        this._lepton     = lepton;
        this._antiLepton = antiLepton
        return this
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override fun getIlluminations() : IParticleBeam {
        return matterAntiMatter.getIlluminations()
    }
}