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
import symmetrical.cosmic.physics.subatomic.spacial.ParticleBeam
import symmetrical.cosmic.physics.subatomic.matter.quarks.Down
import symmetrical.cosmic.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.cosmic.dictionary.protons.ValueProton
import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.balanced.Particle
import symmetrical.cosmic.physics.subatomic.matter.bosons.ZBoson
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic.physics.subatomic.matter.leptons.Electron
import kotlin.reflect.KClass
/*
https://en.wikipedia.org/wiki/Proton
 */
class Protons(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Protons::class),
) : ParticleBeam(),
    IMatterAntiMatter by matterAntiMatter,
    IProtons
{
    val _valueProton: Proton
    init {
        _valueProton = add(ValueProton().setProtons(this)) as ValueProton
    }

    private lateinit var p_nucleons   : Nucleons

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        clear()

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)

        for (i in 0 until size()) {
            (get(i) as Proton).setProtons(this)
        }
        return remainder
    }
    override fun addProton(proton: Proton) : Proton {
        add(proton)
        return proton
    }
    fun capacitanceChange(proton: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
        return getAtom().capacitanceChange(proton, valueQuark, zBoson)
    }

    override fun emit() : Photon {
        return Photon().with(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }


    fun getAtom() : Atom {
        return p_nucleons.getAtom()
    }
    override fun getAtomicNumber() : Int {
        return size()
    }

    fun getElectron(proton: Proton) : Electron {
        val electronNum = _beam.find(proton)
        return getAtom().getElectron(electronNum)
    }
    override fun getProton(classType:KClass<*>) : Proton {
        return get(findByType(classType)) as Proton
    }

    override fun setAtomicNumber(number:Int) : Nucleons {
        var i=size()
        while (i<number) {
            add(
                Baryon().Proton() as Baryon
            )
            i++
        }
        return p_nucleons as Nucleons
    }
    fun setCurrentValue(zBoson: ZBoson) : ZBoson {
        getProton(ValueProton::class).interact(zBoson)
        return zBoson
    }
    override fun setNucleons(nucleons:Nucleons) : Nucleons {
        this.p_nucleons = nucleons
        return nucleons
    }

    fun valueChange(proton: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
        return getAtom().valueChange(proton, valueQuark, zBoson)
    }


    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("Protons")
        }
        val classId:String = matterAntiMatter.getClassId()
        val particleBeam:String = super.emit().radiate()
        return classId+particleBeam
    }
}