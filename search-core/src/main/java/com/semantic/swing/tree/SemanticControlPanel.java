/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SemanticControlPanel.java
 *
 * Created on 19.09.2011, 10:52:18
 */
package com.semantic.swing.tree;

import com.l2fprod.common.propertysheet.PropertySheet;
import com.l2fprod.common.propertysheet.PropertySheetPanel;
import com.semantic.ApplicationContext;
import com.semantic.eventbus.GenericEventBus;
import com.semantic.eventbus.GenericEventListener;
import com.semantic.lucene.facet.FacetQueryHitCountCollector;
import com.semantic.lucene.task.QueryResultEvent;
import com.semantic.model.OModel;
import com.semantic.swing.TextOverlayUI;
import com.semantic.swing.UIDefaults;
import com.semantic.swing.propertysheet.OPropertyEditorRegistry;
import com.semantic.swing.propertysheet.OPropertyRendererRegistry;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import org.apache.lucene.search.IndexSearcher;
import org.jdesktop.jxlayer.JXLayer;

/**
 *
 * @author Christian
 */
public class SemanticControlPanel extends javax.swing.JPanel implements GenericEventListener<QueryResultEvent> {

    private MouseTreeListener popupListener;
    private TextOverlayUI overlayUI;

    /** Creates new form SemanticControlPanel */
    public SemanticControlPanel() {
        super();
        initComponents();
        initOwnComponents();
    }

    private void initOwnComponents() {
        treeScroll.setBorder(UIManager.getBorder(UIDefaults.BORDER_TREE_VIEW));
//        treeScroll.setBorder(null);        
        semanticJTree1.addMouseListener(popupListener = new MouseTreeListener(this));
        semanticJTree1.getSelectionModel().addTreeSelectionListener(popupListener);
        sheetPanel.setBorder(UIManager.getBorder(UIDefaults.PROPERTYSHEET_BORDER));
        sheetPanel.setMode(PropertySheet.VIEW_AS_FLAT_LIST);
        sheetPanel.setToolBarVisible(false);
        sheetPanel.setSorting(false);
        sheetPanel.setSortingProperties(false);
        sheetPanel.setRestoreToggleStates(true);
        /* register renderer factory */
        sheetPanel.setRendererFactory(OPropertyRendererRegistry.def());
        sheetPanel.setEditorFactory(OPropertyEditorRegistry.def());
        /* */
        JXLayer layer = new JXLayer(sheetPanel,
                overlayUI = new TextOverlayUI("<No View available>"));
        layer.setMinimumSize(new Dimension(0, 0));        

//        JStackedBox box = new JStackedBox();
//        box.setBackground(UIManager.getColor(UIDefaults.BACKGROUND_TREE));
//        box.addBoxStyle("Filter Ontology", treeScroll);
//        
//        SemanticJTree tree = new SemanticJTree();
//        tree.setModel(new OModel("My Search"));
//        JScrollPane scroll = new JScrollPane(tree);
//        scroll.setBorder(null);
//        box.addBoxStyle("My Search", scroll);

        treeSplit.add(treeScroll, JSplitPane.LEFT);
        treeSplit.add(layer, JSplitPane.RIGHT);
        treeSplit.setDividerLocation(0.7);
        treeSplit.collapseRight();
        /* listen for query searched events */
        GenericEventBus.addEventListener(QueryResultEvent.class, this);
    }

    public TextOverlayUI getOverlayUI() {
        return overlayUI;
    }

    public SemanticJTree getJTree() {
        return semanticJTree1;
    }

    public PropertySheetPanel getSheetPanel() {
        return sheetPanel;
    }

    /** This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sheetPanel = new com.l2fprod.common.propertysheet.PropertySheetPanel();
        treeScroll = new javax.swing.JScrollPane();
        semanticJTree1 = new com.semantic.swing.tree.SemanticJTree();
        treeSplit = new com.semantic.util.swing.JSplitPaneHack();

        treeScroll.setBorder(null);
        treeScroll.setViewportView(semanticJTree1);

        setLayout(new java.awt.BorderLayout());

        treeSplit.setBorder(null);
        treeSplit.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        add(treeSplit, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.semantic.swing.tree.SemanticJTree semanticJTree1;
    private com.l2fprod.common.propertysheet.PropertySheetPanel sheetPanel;
    private javax.swing.JScrollPane treeScroll;
    private com.semantic.util.swing.JSplitPaneHack treeSplit;
    // End of variables declaration//GEN-END:variables

    @Override
    public void handleEvent(QueryResultEvent event) {
        OModel model = ApplicationContext.instance().getProperty(ApplicationContext.MODEL);
        IndexSearcher searcher = event.getCurrentSearcher();
        /* facet searching */
        FacetQueryHitCountCollector counter = new FacetQueryHitCountCollector(searcher, event.getQuery());
        counter.facetCount(model, false, false);
        /* refresh tree */
        semanticJTree1.repaint();
    }
}