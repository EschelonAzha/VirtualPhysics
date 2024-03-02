package symmetrical.physics.subatomic.matter.hadrons.mesons
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

import symmetrical.physics.subatomic.anti_matter.anti_hadrons.anti_mesons.AntiNeutralUpPion
import symmetrical.physics.subatomic.anti_matter.anti_quarks.AntiQuark
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.physics.subatomic.matter.quarks.Up
import symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.hadrons.Hadron


// For more information visit:   https://en.wikipedia.org/wiki/Pion

open class NeutralUpPion(
    private val matterAntiMatter: IMatter = Matter().with(NeutralUpPion::class),
) : Hadron(),
    IMatter by matterAntiMatter
{
    // The Neutral up Pion binds proton and neutron together
    // by binding the pointers together

    fun with(proton: Baryon, neutron: Baryon) : NeutralUpPion {
        super.capacity(2)
        this.add(Up())
        this.add(AntiUp())

        val up0 = get(0) as Up
        val up1 = get(1) as AntiUp
        up0.getWavelength().setContent(proton)
        up1.getWavelength().setContent(neutron)

        nuclearForce()
        return this
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

    fun getNeutron() : Baryon {
        return (get(1) as Quark).red() as Baryon
    }
    fun getProton() : Baryon {
        return (get(1) as Quark).red() as Baryon
    }
    fun nuclearForce() : NeutralUpPion {
        val protonQ1 = getProton().get(1) as Quark
        val neutronQ1 = getNeutron().get(1) as Quark

        protonQ1.getWavelength().setContent(getNeutron())
        neutronQ1.getWavelength().setContent(getProton())
        return this
    }
}