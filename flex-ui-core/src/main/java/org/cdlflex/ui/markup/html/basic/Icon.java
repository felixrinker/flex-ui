/**
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.cdlflex.ui.markup.html.basic;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.cdlflex.ui.behavior.CssClassNameAppender;
import org.cdlflex.ui.markup.css.icon.IconType;

/**
 * A container that displays an icon from the icon sprite.
 */
public class Icon extends WebMarkupContainer {

    private static final long serialVersionUID = 1L;

    private IModel<IconType> iconType;

    public Icon(String id) {
        super(id);
    }

    public Icon(String id, IconType iconType) {
        this(id, Model.of(iconType));
    }

    public Icon(String id, IModel<IconType> iconType) {
        this(id, iconType, null);
    }

    public Icon(String id, IModel<IconType> iconType, IModel<?> model) {
        super(id, model);
        this.iconType = iconType;
    }

    public IModel<IconType> getIconType() {
        return iconType;
    }

    public void setIconType(IModel<IconType> iconType) {
        this.iconType = iconType;
    }

    public boolean hasIconType() {
        IModel<IconType> model = getIconType();
        return model != null && model.getObject() != null;
    }

    /**
     * Sets the icon type.
     * 
     * @param type the icon type
     * @return this for chaining
     */
    public Icon setIconType(IconType type) {
        this.iconType.setObject(type);
        return this;
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        IModel<IconType> typeModel = getIconType();
        if (typeModel != null && typeModel.getObject() != null) {
            CssClassNameAppender.append(tag, typeModel);
        }
    }
}
