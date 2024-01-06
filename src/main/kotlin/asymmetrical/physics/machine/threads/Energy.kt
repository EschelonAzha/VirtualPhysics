package asymmetrical.physics.machine.threads
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

import asymmetrical.physics.machine.config.Config

open class Energy : Thread  {
    @Volatile protected var running     = false
    @Volatile protected var updating    = false
    constructor() {
    }

    fun acquireRunning() : Boolean {
        while (updating) {
            Thread.sleep(Config.getUpdateSleep())
        }
        running = true
        if (updating) { // got it too late
            running = false
            return false // try again.
        }
        return true
    }

    fun acquireUpdate() : Boolean {
        while (running) {
            Thread.sleep(Config.getUpdateSleep())
        }
        updating = true
        if (running) {  // got it too late
            updating = false
            return false
        }
        return true
    }
    fun pause() : Unit {
        releaseRunning()
        Thread.sleep(Config.getThreadSleep())
        while (!acquireRunning()){}
    }
    fun releaseRunning() : Unit {
        running = false
        return
    }
    fun releaseUpdate() : Unit {
        updating = false
        return
    }
}