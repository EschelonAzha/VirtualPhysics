package symmetrical.cosmic.physics.atomic.atoms.nucleons
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

import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic.physics.subatomic.spacial.ParticleBeam
import symmetrical.cosmic.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Neutron
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton

/*
https://en.wikipedia.org/wiki/Neutron
 */
class Neutrons(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Neutrons::class, Neutrons::class),
) : ParticleBeam(),
    IMatterAntiMatter by matterAntiMatter,
    INeutrons
{
    constructor()  : this(
        MatterAntiMatter(Neutrons::class, Neutrons::class),
    )

    lateinit var p_nucleons: Nucleons

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        clear()

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)

        for (i in 0 until size()) {
            (get(i) as Neutron).setNeutrons(this)
        }
        return remainder
    }
    override fun addNeutron(neutron: Neutron) : Neutron {
        add(neutron)
        return neutron
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    override fun findNeutron(purpose:String) : Int {
        var i=0;
        while (i<size()) {
            val baryon = get(i) as Proton
            if ((baryon.get(2) as Quark).red() == purpose) {
                return i
            }
            i++
        }
        return -1
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override fun getNeutron(pos:Int) : Neutron {
        return get(pos) as Neutron
    }
    override fun getNeutron(purpose:String) : Neutron {
        var pos = findNeutron(purpose)

        if (pos!=-1)
            return getNeutron(pos) as Neutron

        var neutron = Neutron()
        neutron.setPurpose(purpose)
        addNeutron(neutron)
        return neutron
    }
    override fun setNucleons(nucleons: Nucleons) : Nucleons {
        this.p_nucleons = nucleons
        return nucleons
    }

    private fun radiate() : String {
        val classId : String = matterAntiMatter.getClassId()
        val particleBeam : String = super.emit().radiate()
        return classId+particleBeam
    }
}