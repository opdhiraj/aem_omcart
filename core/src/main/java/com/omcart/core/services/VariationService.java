package com.omcart.core.services;

import com.adobe.cq.sightly.WCMUsePojo;
import com.omcart.core.models.VariationModal;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import java.util.ArrayList;
import java.util.List;

@Component(service = VariationService.class,immediate = true)

public class VariationService extends WCMUsePojo {

    private  final Logger logger= LoggerFactory.getLogger(VariationService.class);


    List<VariationModal>list=new ArrayList<VariationModal>();

    public List<VariationModal> getList() {
        return list;

    }

    @Override
    public void activate() throws Exception {
        //this fetch the fifth component node
        Node fifth=getResource().adaptTo(Node.class);
        logger.debug("fifth-------------- {}",fifth );

       // getNodes method will provide an iterator on all the immediate child nodes of the fifth.

        NodeIterator iterator =fifth.getNodes();

        while (iterator.hasNext()){
            Node variation =iterator.nextNode();
            if (variation.getName().equals("variation")){

                //getname is from item interface

                NodeIterator iterator2=variation.getNodes();
                while (iterator2.hasNext()){
                    Node item= iterator2.nextNode();
                    VariationModal model= new VariationModal();

                    String vname=item.getProperty("variationName").getString();
                    model.setVariationName(vname);

                    String vcolor=item.getProperty("variationColor").getString();
                    model.setVariationColor(vcolor);

                    String vprice=item.getProperty("variationPrice").getString();
                    model.setVariationPrice(Double.parseDouble(vprice));

                    list.add(model);
                }

            }
        }
    }



}
