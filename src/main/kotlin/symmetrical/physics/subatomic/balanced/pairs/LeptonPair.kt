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
import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.matter.leptons.Lepton
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.physics.subatomic.spacial.IParticleBeam

// For more information visit:   https://en.wikipedia.org/wiki/Pair_production

open class LeptonPair(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter().with(LeptonPair::class),
) : Particle(),
    IMatterAntiMatter by matterAntiMatter
{
    public lateinit var _lepton     : Lepton
    public lateinit var _antiLepton : AntiLepton

    open fun with(lepton:Lepton, antiLepton: AntiLepton) : LeptonPair {
        this._lepton     = lepton;
        this._antiLepton = antiLepton
        return this
    }
    override fun getIlluminations() : IParticleBeam {
        return matterAntiMatter.getIlluminations()
    }






    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

}