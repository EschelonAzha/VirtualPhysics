package symmetrical.physics.atomic.atoms.nucleons
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

import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.spacial.ParticleBeam
import symmetrical.physics.subatomic.matter.quarks.Down
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.cosmic.dictionary.protons.ValueProton
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.physics.subatomic.matter.leptons.Electron
import kotlin.reflect.KClass

// For more information visit:  https://en.wikipedia.org/wiki/Proton

class Protons(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter().with(Protons::class),
) : ParticleBeam(),
    IMatterAntiMatter by matterAntiMatter,
    symmetrical.physics.atomic.atoms.nucleons.IProtons
{
    private val _valueProton    : symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
    private lateinit var p_nucleons      : Nucleons

    init {
        _valueProton = add(ValueProton().setProtons(this)) as ValueProton
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        clear()

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)

        for (i in 0 until size()) {
            (get(i) as symmetrical.physics.subatomic.matter.hadrons.baryons.Proton).setProtons(this)
        }
        return remainder
    }
    override fun addProton(proton: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton) : symmetrical.physics.subatomic.matter.hadrons.baryons.Proton {
        add(proton)
        return proton
    }
    fun capacitanceChange(proton: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton, valueQuark: Down, zBoson: symmetrical.physics.subatomic.matter.bosons.ZBoson) : symmetrical.physics.subatomic.matter.bosons.ZBoson {
        return getAtom().capacitanceChange(proton, valueQuark, zBoson)
    }

    override fun emit() : Photon {
        return Photon().with(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }


    fun getAtom() : symmetrical.physics.atomic.atoms.Atom {
        return p_nucleons.getAtom()
    }
    override fun getAtomicNumber() : Int {
        return size()
    }

    fun getElectron(proton: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton) : symmetrical.physics.subatomic.matter.leptons.Electron {
        val electronNum = _beam.find(proton)
        return getAtom().getElectron(electronNum)
    }
    override fun getProton(classType:KClass<*>) : symmetrical.physics.subatomic.matter.hadrons.baryons.Proton {
        return get(findByType(classType)) as symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
    }
    fun interact(zBoson: symmetrical.physics.subatomic.matter.bosons.ZBoson) : symmetrical.physics.subatomic.matter.bosons.ZBoson {
        getProton(ValueProton::class).interact(zBoson)
        return zBoson
    }
    override fun setNucleons(nucleons:Nucleons) : Nucleons {
        this.p_nucleons = nucleons
        return nucleons
    }

    fun valueChange(proton: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton, valueQuark: Down, zBoson: symmetrical.physics.subatomic.matter.bosons.ZBoson) : symmetrical.physics.subatomic.matter.bosons.ZBoson {
        return getAtom().valueChange(proton, valueQuark, zBoson)
    }

    private fun radiate() : String {
        if (symmetrical.physics.subatomic.balanced.Particle.Static.debuggingOn) {
            println("Protons")
        }
        val classId:String = matterAntiMatter.getClassId()
        val particleBeam:String = super.emit().radiate()
        return classId+particleBeam
    }
}