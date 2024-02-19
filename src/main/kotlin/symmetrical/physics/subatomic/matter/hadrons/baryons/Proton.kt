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

import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.subatomic.matter.quarks.Down
import symmetrical.physics.subatomic.matter.quarks.Up
import symmetrical.physics.subatomic.spacial.ParticleBeam
import symmetrical.physics.atomic.atoms.nucleons.Protons
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.luminescent.QuasiParticle
import symmetrical.physics.subatomic.balanced.IParticle
import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.matter.leptons.Electron


// For more information visit:   https://en.wikipedia.org/wiki/Proton

open class Proton(
    private val matterAntiMatter: IMatter = Matter().with(Proton::class),
) : Baryon(),
    IMatter by matterAntiMatter
{
    var _quark:Quark
    private var p_protons       : Protons? = null
    private var autoFlow        : Boolean  = true
    private var flowing         : Boolean  = false

    // +2/3 wavelength(value),                 Spin(isFormatted),          AngularMomentum(Format),
    // +2/3 wavelength(validator),             Spin(isValidationActive),   AngularMomentum(Ptr to Electron),
    // -1/3 wavelength(Type Of Proton),        Spin(?),
    init {
        this.add(Down().with(this))  // value
        this.add(Up().with(this))    // format
        this.add(Up().with(this))    // constraints

        _quark = this.get(0) as Quark
        shrink()
    }

    fun with(value:Any?) : Proton {
        getValueQuark().setContent(value)
        return this
    }

    enum class QuarkType(val value:Int) {
        VALUE(0),
        CONSTRAINTS(1),
        FORMAT(2),
    }

    object Static {
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        clear()
        var remainder = photon.propagate()

        remainder = super.absorb(remainder)

        _quark    = get(0) as Quark
        return remainder
    }
    fun capacitanceChange(zBoson: ZBoson) : ZBoson {
        if (p_protons != null)
            p_protons!!.capacitanceChange(this, getValueQuark(), zBoson)

        return zBoson
    }
    fun covalentBond(proton: Proton, autoFlow:Boolean = true) : Proton {
        proton.autoFlow = autoFlow
        val myElectron  = getElectron()
        val youElectron = proton.getElectron()
        if (myElectron == null)
            return this
        if (youElectron ==  null)
            return this
        myElectron.covalentBond(youElectron)
        return this
    }

    override fun emit() : Photon {
        val classId = matterAntiMatter.getClassId()
        return Photon().with(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    fun getConstraintsQuark() : Up {
        return get(Proton.QuarkType.CONSTRAINTS.value) as Up
    }

    fun getFormatQuark() : Up {
        return get(Proton.QuarkType.FORMAT.value) as Up
    }
    fun getValueQuark() : Down {
        return get(Proton.QuarkType.VALUE.value) as Down
    }

    fun ionicBond(proton: Proton) : Proton {
        val myElectron  = getElectron()
        val youElectron = proton.getElectron()
        if (myElectron == null)
            return this
        if (youElectron ==  null)
            return this
        myElectron.ionicBond(youElectron)
        return this
    }
    fun interact(zBoson: ZBoson) : ZBoson {
        if (flowing)
            return zBoson

        val newValue  : Field                       = zBoson.getNewField()
        val valueQuark: Down                        = getValueQuark()
        val wavelength: QuasiParticle = valueQuark.getWavelength().getQuantumField()
        zBoson.setOldValue(wavelength.getContent())

        if (!noChange(zBoson).isAccepted())
            return zBoson // not accepted, nothing changed

        var accept = valueChange(valueQuark, zBoson)
        if (!zBoson.isAccepted()) {
            return zBoson  // preValueChange rejected change
        }

        if (autoFlow) {
            flowing = true
            val beam: ParticleBeam = flow() // beam has the remote changes.   Not being used yet
            flowing = false
        }

        return zBoson  // this returns only the local changes
    }
    fun setConstraintsQuark(up:Up) : Proton {
        set(Proton.QuarkType.CONSTRAINTS.value, up)
        return this
    }

    fun setFormatQuark(up:Up) : Proton {
        set(Proton.QuarkType.FORMAT.value, up)
        return this
    }
    fun setValueQuark(down:Down) : Proton {
        _quark = set(Proton.QuarkType.VALUE.value, down) as Quark
        return this
    }

    fun setProtons(protons:Protons) : Proton {
        this.p_protons = protons
        return this
    }


    private fun flow() : ParticleBeam {
        val electron: Electron = getElectron() ?: return ParticleBeam()
        return electron.flow()
    }
    private fun getElectron() : Electron? {
        val electron : Electron = p_protons?.getElectron(this) ?: return null

        electron.setProton(this)

        return electron
    }


    private fun noChange(zBoson: ZBoson) : ZBoson {
        val newValue  : Field                   = zBoson.getNewField()
        val valueQuark: Down                    = getValueQuark()
        val wavelength: QuasiParticle = valueQuark.getWavelength().getQuantumField()
        if (!wavelength.isChange(newValue)) {
            zBoson.setAccepted(false)
        }
        zBoson.setAccepted(true)
        return zBoson
    }
    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("Proton")
        }

        val classId : String = matterAntiMatter.getClassId()
        val baryon  : String = super.emit().radiate()
        return classId+baryon
    }
    private fun valueChange(valueQuark:Down, zBoson: ZBoson) : ZBoson {
        if (p_protons != null)
            p_protons!!.valueChange(this, valueQuark, zBoson)
        return zBoson
    }


}