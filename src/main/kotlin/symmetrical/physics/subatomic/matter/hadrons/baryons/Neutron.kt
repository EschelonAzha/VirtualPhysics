package symmetrical.physics.subatomic.matter.hadrons.baryons
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

import symmetrical.physics.atomic.atoms.nucleons.Neutrons
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.anti_matter.anti_hadrons.anti_baryons.AntiNeutron
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.quarks.Down
import symmetrical.physics.subatomic.matter.quarks.Up


// For more information visit:   https://en.wikipedia.org/wiki/Neutron

open class Neutron(
    private val matterAntiMatter: IMatter = Matter().with(Neutron::class),
) : Baryon(),
    IMatter by matterAntiMatter
{
    lateinit var __neutrons: Neutrons

    // +2/3 wavelength(value),                 Spin(isFormatted),          AngularMomentum(Format),
    // -1/3 wavelength(?),                     Spin(?),                    AngularMomentum(Ptr to Proton),
    // -1/3 wavelength(?),                     Spin(?),                    AngularMomentum(Ptr to Next Neutron),
    init {
        this.add(Up().with(this))    // value
        this.add(Down().with(this))  // When down Points to Proton
        this.add(Down().with(this))  // type
        shrink()
    }
    fun setNeutrons(neutrons: Neutrons) : Neutron {
        this.__neutrons = neutrons
        return this
    }







    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+
                super.emit().radiate()
    }
    // ########################### EMISSIONS ###########################
}