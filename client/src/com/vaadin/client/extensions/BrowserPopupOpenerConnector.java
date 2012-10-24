/*
 * Copyright 2012 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.vaadin.client.extensions;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.server.BrowserPopupOpener;
import com.vaadin.shared.ui.BrowserPopupExtensionState;
import com.vaadin.shared.ui.Connect;

/**
 * Client-side code for {@link BrowserPopupOpener}
 * 
 * @author Vaadin Ltd
 * @since 7.0.0
 */
@Connect(BrowserPopupOpener.class)
public class BrowserPopupOpenerConnector extends AbstractExtensionConnector
        implements ClickHandler {

    @Override
    protected void extend(ServerConnector target) {
        final Widget targetWidget = ((ComponentConnector) target).getWidget();

        targetWidget.addDomHandler(this, ClickEvent.getType());
    }

    @Override
    public BrowserPopupExtensionState getState() {
        return (BrowserPopupExtensionState) super.getState();
    }

    @Override
    public void onClick(ClickEvent event) {
        String url = getResourceUrl("popup");
        if (url != null) {
            Window.open(url, getState().target, getState().features);
        }
    }
}