/*
 * Copyright (c) 2021 jose1.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    jose1 - initial API and implementation and/or initial documentation
 */
package ec.edu.espe.distribuidas.examen.zuniga.mongo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateRS<T> extends Response {
    private T primaryKey;
}
