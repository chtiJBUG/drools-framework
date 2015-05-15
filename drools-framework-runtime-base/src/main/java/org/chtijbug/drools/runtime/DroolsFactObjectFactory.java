/*
 * Copyright 2014 Pymma Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.chtijbug.drools.runtime;

import org.apache.commons.beanutils.BeanMap;
import org.chtijbug.drools.entity.DroolsFactObject;
import org.chtijbug.drools.entity.DroolsFactObjectAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bertrand Gressier
 * @date 27 déc. 2011
 */
public class DroolsFactObjectFactory {

    private static Logger logger = LoggerFactory.getLogger(DroolsFactObjectFactory.class);

    protected DroolsFactObjectFactory() {

    }

    public static DroolsFactObject createFactObject(Object o,boolean isJsonGeneratorIsable) {
        return createFactObject(o, 0,isJsonGeneratorIsable);
    }

    public static DroolsFactObject createFactObject(Object o, int version,boolean isJsonGeneratorIsable) {
        logger.debug(">>createFactObject", o, version);
        DroolsFactObject createFactObject = null;
        try {
            if (o != null) {
                createFactObject = new DroolsFactObject(o, version,isJsonGeneratorIsable);
                createFactObject.setFullClassName(o.getClass().getCanonicalName());
                createFactObject.setHashCode(o.hashCode());

                BeanMap m = new BeanMap(o);
                for (Object para : m.keySet()) {
                    if (!para.toString().equals("class")) {
                        if (m.get(para) != null) {
                            DroolsFactObjectAttribute attribute = new DroolsFactObjectAttribute(para.toString(), m.get(para).toString(), m.get(para).getClass().getSimpleName());
                            createFactObject.getListfactObjectAttributes().add(attribute);
                        } else {
                            DroolsFactObjectAttribute attribute = new DroolsFactObjectAttribute(para.toString(), "null", "null");
                            createFactObject.getListfactObjectAttributes().add(attribute);
                        }

                    }

                }
            }
        } catch (Exception e) {
            logger.error("Not possible to introspect {} for reason {}", o, e);
        } finally {
            logger.debug("<<createFactObject", createFactObject);
            return createFactObject;
        }
    }

}
